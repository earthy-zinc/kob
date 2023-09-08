import type { PageData, PageQuery } from '~/types'
import type { Friend } from '~/types/friend'

export const FriendApi = {
  sendFriendVerification: (userId: number) => R.get('/friend/verification', { params: { id: userId } }),
  handleFriendRequest: (params: {
    userId: number
    friendId: number
    type: number
  }) => R.post('/friend', { params }),
  deleteFriend: (friendId: number) => R.delete('/friend', { params: { id: friendId } }),
  getFriendList: (params: PageQuery & { name?: string }) => R.get<PageData<Friend>>('/friend/list', { params }),
  getUserList: (params: PageQuery & { name?: string }) => R.get<PageData<Friend>>('/user/list', { params }),
}
