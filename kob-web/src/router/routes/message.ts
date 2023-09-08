import { BaseLayout } from '~/layout'

export default {
  path: '/message',
  component: BaseLayout,
  children: [
    {
      path: '',
      name: 'Message',
      component: () => import('~/pages/message/index.vue'),
      meta: {
        title: '我的消息',
        requiresAuth: true,
      },
    },
  ],
}
