<script setup lang="ts">
import {
  BagAddOutline,
  BagRemoveOutline,
  Refresh as RefreshIcon,
  Search as SearchIcon,
  TrashBinOutline as TrashBinOutlineIcon,
} from '@vicons/ionicons5'
import { createColumns } from '~/pages/rank/columns'
import type { Rank } from '~/types'

const { isMobile, labelHidden } = useResponsive()
const { loading, startLoading, endLoading } = useLoading()
const pagination = usePagination({ // 分页参数
  onChangeCallback: fetchTableData,
  onUpdatePageSizeCallback: fetchTableData,
})

const columns = createColumns({
  createRowNumber: pagination.createRowNumber,
})

let tableData = $ref<Rank[]>([])
const searchModel = reactive<{ name?: string }>({ name: '' })

function fetchTableData() {
  startLoading()
  const { page, pageSize } = pagination
  RankApi
    .getRankList({ page, pageSize, name: searchModel.name?.trim() })
    .then(({ data: { records = [], total = 0 } }) => {
      tableData = records
      pagination.itemCount = total
    })
    .finally(() => useTimeoutFn(endLoading, 1000))
}
fetchTableData()
</script>

<template>
  <div w-full>
    <n-card title="交易所" hoverable>
      <template v-if="!isMobile" #header-extra>
        <div flex gap-x-2>
          <n-form-item label="道具名称" label-placement="left" :show-label="!labelHidden" :show-feedback="false">
            <n-input v-model:value="searchModel.name" placeholder="道具名称" clearable :style="{ width: '150px' }">
              <template #clear-icon>
                <n-icon :component="TrashBinOutlineIcon" />
              </template>
            </n-input>
          </n-form-item>
          <n-button type="primary" text-color="white" @click="fetchTableData">
            <template #icon>
              <n-icon :component="SearchIcon" color="white" />
            </template>
            <span font-bold>查询</span>
          </n-button>
          <n-button secondary @click="searchModel.name = '' && fetchTableData()">
            <template #icon>
              <n-icon :component="RefreshIcon" />
            </template>
            <span font-bold>重置</span>
          </n-button>
          <n-button type="primary" text-color="white" style="margin-left: 15px" @click="fetchTableData">
            <template #icon>
              <n-icon :component="BagAddOutline" color="white" />
            </template>
            <span font-bold>我购买的</span>
          </n-button>
          <n-button type="primary" text-color="white" @click="fetchTableData">
            <template #icon>
              <n-icon :component="BagRemoveOutline" color="white" />
            </template>
            <span font-bold>我售卖的</span>
          </n-button>
        </div>
      </template>
      <n-data-table
        v-if="!isMobile"
        size="small"
        :loading="loading"
        :columns="columns"
        :data="tableData"
        :remote="true"
        :pagination="pagination"
        :paginate-single-page="false"
      />
      <div
        v-else
        hw-full
        flex-center
        text-lg
      >
        {  请在客户端访问 :). }
      </div>
    </n-card>
  </div>
</template>

<style scoped>

</style>
