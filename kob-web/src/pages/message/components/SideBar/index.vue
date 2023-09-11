<script setup lang="ts">
import type { MenuOption } from 'naive-ui'
import { RouterLink } from 'vue-router'
// eslint-disable-next-line prefer-const
let activeMenu = ref<string>('')
const route = useRoute()

onMounted(() => {
  activeMenu.value = route.name as string
})

const menuOptions: MenuOption[] = [
  {
    label: () => h(RouterLink, {
      to: {
        path: '/message/game',
      },
    },
    { default: () => '对战结果' },
    ),
    key: 'gameMessage',
  },
  {
    label: () => h(RouterLink, {
      to: {
        path: 'chat',
      },
    },
    { default: () => '聊天消息' },
    ),
    key: 'chatMessage',
  },
  {
    label: () => h(RouterLink, {
      to: {
        path: '/message/friend',
      },
    },
    { default: () => '好友消息' },
    ),
    key: 'friendMessage',
  },
  {
    label: () => h(RouterLink, {
      to: {
        path: '/message/system',
      },
    },
    { default: () => '系统消息' },
    ),
    key: 'systemMessage',
  },
  {
    label: () => h(RouterLink, {
      to: {
        path: '/message/settings',
      },
    },
    { default: () => '消息设置' },
    ),
    key: 'messageSetting',
  },
]
</script>

<template>
  <n-scrollbar>
    <div style="text-align: center; font-weight: bold; height: 60px; line-height: 60px">
      消息中心
    </div>
    <n-divider style="margin: 0" />
    <n-menu :value="activeMenu" :options="menuOptions" style="text-align: center" :root-indent="16" />
  </n-scrollbar>
</template>

<style>

</style>
