<script setup lang="ts">
import {
  Refresh as RefreshIcon,
  Search as SearchIcon,
  TrashBinOutline as TrashBinOutlineIcon,
} from '@vicons/ionicons5'
import { createColumns } from '~/pages/friend/columns'
import { FriendApi } from '~/server/api/friend'
import type { Friend } from '~/types'

const { isMobile, labelHidden } = useResponsive()
const searchModel = reactive<{ name: string }>({ name: '' })
const { loading, startLoading, endLoading } = useLoading()

const pagination = usePagination({ // 分页参数
  onChangeCallback: fetchTableData,
  onUpdatePageSizeCallback: fetchTableData,
})

const columns = createColumns({
  createRowNumber: pagination.createRowNumber,
  canDelete,
  checkRecord,
})
let tableData = $ref<Friend[]>([])
function canDelete(friendId: number): boolean {
  // TODO
  return false
}
function checkRecord(friendId: number): Friend {
  // TODO
  return {
    id: 1,
    username: 'string',
    name: 'string',
    avatar: 'string',
    rating: 1,
    createTime: new Date(),
  }
}
function fetchTableData() {
  startLoading()
  const { page, pageSize } = pagination
  const data = [
    { id: 1, username: 'xswl', name: '我欲焚天', avatar: '暂无', rating: 1245, createTime: new Date() },
  ]
  FriendApi
    .getFriendList({ page, pageSize, name: searchModel.name?.trim() })
    .then(({ data: { records = [], total = 0 } }) => {
      tableData = data
      pagination.itemCount = total
    })
    .finally(() => {
      tableData = data
      useTimeoutFn(endLoading, 1000)
    })
}
fetchTableData()
</script>

<template>
  <div w-full>
    <n-card title="好友列表" hoverable>
      <template v-if="!isMobile" #header-extra>
        <div flex gap-x-2>
          <n-form-item label="好友名称" label-placement="left" :show-label="!labelHidden" :show-feedback="false">
            <n-input v-model:value="searchModel.name" placeholder="好友名称" clearable :style="{ width: '150px' }">
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
