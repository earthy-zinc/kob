import { NButton } from 'naive-ui'
import type { DataTableColumns } from 'naive-ui'
import type { Friend } from '~/types/friend'

export function createColumns({
  createRowNumber,
  canDelete,
  checkRecord,
}: {
  createRowNumber?: (rowIndex: number) => number
  canDelete?: (friendId: number) => boolean
  checkRecord?: (friendId: number) => Friend
}): DataTableColumns<Friend> {
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
      title: '好友',
      key: 'friend',
      align: 'center',
      render({ username, name, avatar }) {
        return renderPlayer(username, name, avatar)
      },
    },
    {
      key: 'rating',
      title: '天梯分',
      align: 'center',
      render({ rating }) {
        return `${rating} 分`
      },
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
              type: 'primary',
              textColor: 'white',
              onClick: () => checkRecord?.(row.id as number),
            },
            { default: () => '查看战绩' },
          ),
          h(
            NButton,
            {
              size: 'small',
              type: 'error',
              textColor: 'white',
              onClick: () => canDelete?.(row.id as number),
            },
            { default: () => '删除好友' },
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

function renderPlayer(username?: string, name?: string, avatar?: string) {
  return null
}
