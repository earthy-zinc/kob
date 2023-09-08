import { BaseLayout } from '~/layout'

export default {
  path: '/friend',
  component: BaseLayout,
  children: [
    {
      path: '',
      name: 'Friend',
      component: () => import('~/pages/friend/index.vue'),
      meta: {
        title: '我的好友',
        requiresAuth: true,
      },
    },
  ],
}
