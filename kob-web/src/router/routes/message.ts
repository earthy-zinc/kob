import { BaseLayout } from '~/layout'
export default {
  path: '/message',
  component: BaseLayout,
  children: [
    {
      path: '',
      name: 'Message',
      component: () => import('~/pages/message/index.vue'),
      redirect: '/message/chat',
      meta: {
        title: '我的消息',
        requiresAuth: true,
      },
      children: [
        {
          path: 'chat',
          name: 'chatMessage',
          component: () => import('~/pages/message/pages/ChatMessage/index.vue'),
          meta: {
            title: '聊天消息',
            requiresAuth: true,
          },
        },
        {
          path: 'system',
          name: 'SystemMessage',
          component: () => import('~/pages/message/pages/SystemMessage/index.vue'),
          meta: {
            title: '系统消息',
            requiresAuth: true,
          },
        },
        {
          path: 'friend',
          name: 'friendMessage',
          component: () => import('~/pages/message/pages/ChatMessage/index.vue'),
          meta: {
            title: '好友消息',
            requiresAuth: true,
          },
        },
        {
          path: 'game',
          name: 'gameMessage',
          component: () => import('~/pages/message/pages/GameResult/index.vue'),
          meta: {
            title: '对战结果',
            requiresAuth: true,
          },
        },
        {
          path: 'settings',
          name: 'messageSetting',
          component: () => import('~/pages/message/pages/MessageSetting/index.vue'),
          meta: {
            title: '消息设置',
            requiresAuth: true,
          },
        },
      ],
    },
  ],
}
