import type { Component } from 'vue'
import { NIcon } from 'naive-ui'
import { RobotOutlined as BotIcon } from '@vicons/antd'
import {
  ChatbubblesOutline,
  People as FriendIcon,
  LogOutOutline as LogoutIcon,
  NotificationsOutline as NotificationIcon,
  PersonCircleOutline as UserIcon,
} from '@vicons/ionicons5'
import type { Router } from 'vue-router'

const renderIcon = (icon: Component) => () => h(NIcon, null, {
  default: () => h(icon),
})

export const createDropdownOptions = (router: Router, userStore = useUserStore()) => ([
  {
    label: '个人中心',
    key: 'profile',
    icon: renderIcon(UserIcon),
    props: {
      onClick: () => router.push('/profile'),
    },
  },
  {
    label: '我的Bot',
    key: 'userBot',
    icon: renderIcon(BotIcon),
    props: {
      onClick: () => router.push('/userBot'),
    },
  },
  {
    label: '我的消息',
    key: 'message',
    icon: renderIcon(NotificationIcon),
    props: {
      onClick: () => $notification.info({
        content: '暂未实现，敬请期待',
        duration: 30 * 1000,
      }),
    },
  },
  {
    label: '我的好友',
    key: 'friend',
    icon: renderIcon(FriendIcon),
    props: {
      onClick: () => router.push('/friend'),
    },
  },
  {
    label: '反馈中心',
    key: 'discuss',
    icon: renderIcon(ChatbubblesOutline),
    props: {
      onClick: () => router.push('/discuss'),
    },
  },
  {
    label: '退出登录',
    key: 'logout',
    icon: renderIcon(LogoutIcon),
    props: {
      onClick: () => {
        $notification.success({
          title: '登出成功',
          content: '记得回来~',
          duration: 1000,
        })
        router.push('/home')
        useTimeoutFn(userStore.logout, 500)
      },
    },
  },
])
