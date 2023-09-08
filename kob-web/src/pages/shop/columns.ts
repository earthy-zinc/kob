import { NButton } from 'naive-ui'
import type { DataTableColumns } from 'naive-ui'
import type { Product } from '~/types'

export function createColumns({
  createRowNumber,
}: {
  createRowNumber?: (rowIndex: number) => number
}): DataTableColumns<Product> {
  return [
    {
      key: 'id',
      title: '序号',
      align: 'center',
      render(_row, rowIndex) {
        return createRowNumber?.(rowIndex)
      },
    },
    {
      title: '道具',
      key: 'prop_id',
      align: 'center',
      render({ prop_name, prop_avatar }) {
        return renderColumn(prop_name, prop_avatar)
      },
    },
    {
      key: 'seller_id',
      title: '卖家',
      align: 'center',
      render({ seller_name, seller_avatar }) {
        return renderColumn(seller_name, seller_avatar)
      },
    },
    {
      key: 'description',
      title: '商品描述',
      align: 'center',
      render({ description }) {
        return description
      },
    },
    {
      key: 'price',
      title: '商品单价',
      align: 'center',
      render({ priceUint, price }) {
        return renderPrice(priceUint, price)
      },
    },
    {
      key: 'number',
      title: '商品数量',
      align: 'center',
      render({ number }) {
        return `${number} 个`
      },
    },
    {
      key: 'total_price',
      title: '总价',
      align: 'center',
      render({ priceUint, totalPrice }) {
        return renderPrice(priceUint, totalPrice)
      },
    },
    {
      title: '挂出时间',
      key: 'createTime',
      align: 'center',
      render: ({ createTime }) => formatDate({ date: createTime }),
    },
    {
      key: 'action',
      title: '操作',
      align: 'center',
      render(row) {
        const btnArray = [
          h(
            NButton,
            {
              size: 'small',
              type: 'info',
              textColor: 'white',
            },
            { default: () => '聊天' },
          ),
          h(
            NButton,
            {
              size: 'small',
              type: 'primary',
              textColor: 'white',
              style: { marginLeft: '10px' },
            },
            { default: () => '购买' },
          ),
        ]
        return h(
          'div',
          {},
          btnArray,
        )
      },
    },
  ]
}

function renderColumn(name?: string, avatar?: string) {
  return `${name} ${avatar}`
}
function renderPrice(priceUint?: string, price?: number) {
  return `${price} ${priceUint}`
}
