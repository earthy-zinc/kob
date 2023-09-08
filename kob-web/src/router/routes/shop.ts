import { BaseLayout } from '~/layout'

export default {
  path: '/shop',
  component: BaseLayout,
  children: [
    {
      path: '',
      name: 'Shop',
      component: () => import('~/pages/shop/index.vue'),
      meta: {
        title: '交易所',
        requiresAuth: true,
      },
    },
  ],
}
