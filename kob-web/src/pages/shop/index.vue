<script setup lang="ts">
import {
  BagAddOutline,
  BagRemoveOutline,
  Refresh as RefreshIcon,
  Search as SearchIcon,
  TrashBinOutline as TrashBinOutlineIcon,
} from '@vicons/ionicons5'
import { createColumns } from '~/pages/shop/columns'
import type { Product } from '~/types'

const { isMobile, labelHidden } = useResponsive()
const { loading, startLoading, endLoading } = useLoading()
const pagination = usePagination({ // 分页参数
  onChangeCallback: fetchTableData,
  onUpdatePageSizeCallback: fetchTableData,
})

const columns = createColumns({
  createRowNumber: pagination.createRowNumber,
})

let tableData = $ref<Product[]>([])
const searchModel = reactive<{ name?: string }>({ name: '' })

function fetchTableData() {
  startLoading()
  const { page, pageSize } = pagination
  const data = [
    { id: 1, prop_id: 1, prop_name: '炸弹', prop_avatar: '', seller_id: 1, sell_name: '我欲焚天', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 2, prop_id: 1, prop_name: '路障', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 3, prop_id: 1, prop_name: '延时器', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 4, prop_id: 1, prop_name: '路障', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 5, prop_id: 1, prop_name: '炸弹', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 6, prop_id: 1, prop_name: '剪刀', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 7, prop_id: 1, prop_name: '剪刀', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
    { id: 8, prop_id: 1, prop_name: '剪刀', prop_avatar: '', seller_id: 1, sell_name: '小菜鸡', description: '爱买不买', priceUint: 'ethm', number: 10, price: 12, totalPrice: 120, createTime: new Date() },
  ]
  RankApi
    .getRankList({ page, pageSize, name: searchModel.name?.trim() })
    .then(({ data: { records = [], total = 0 } }) => {
      tableData = data
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
