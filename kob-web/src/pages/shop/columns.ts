import { RibbonOutline } from '@vicons/ionicons5'
import { NAvatar, NButton, NEllipsis, NIcon, NIconWrapper, NTooltip } from 'naive-ui'
import type { DataTableColumns } from 'naive-ui'
import type { Product } from '~/types'
import defaultAvatar from '~/assets/default-avatar.png'

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
      key: 'prop_name',
      align: 'center',
      render({ prop_id, prop_name, prop_avatar }) {
        return renderColumn(prop_id, prop_name, prop_avatar)
      },
    },
    {
      key: 'seller_name',
      title: '卖家',
      align: 'center',
      render({ seller_id, seller_name, seller_avatar }) {
        return renderColumn(seller_id, seller_name, seller_avatar, 'seller')
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

function renderColumn(id?: number, name?: string, avatar?: string, type?: string) {
  const widgets = [
    h(
      NAvatar,
      {
        size: 'small',
        round: true,
        src: (avatar && avatar !== '') ? avatar : defaultAvatar,
      },
    ),
    h(
      NEllipsis,
      {
        maxWidth: '200px',
        style: {
          marginLeft: '10px',
        },
      },
      () => name,
    ),
  ]
  if (id === 1 && type === 'seller') {
    widgets.push(h(NTooltip, { trigger: 'hover' },
      {
        trigger: () =>
          h(NIconWrapper, {
            size: 24,
            borderRadius: 10,
            color: '#886BFA',
            iconColor: 'white',
            style: {
              marginLeft: '10px',
            },
          },
          () => h(NIcon, {
            size: 16,
            component: RibbonOutline,
          })),
        default: () => '官方认证，非常可靠',
      }))
  }
  return h('div', {
    style: {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
    },
  }, widgets)
}
function renderPrice(priceUint?: string, price?: number) {
  return `${price} ${priceUint}`
}
