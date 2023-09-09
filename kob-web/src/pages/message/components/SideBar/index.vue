<script setup lang="ts">
import type { MenuOption } from 'naive-ui'
import { NIcon } from 'naive-ui'
import type { Component } from 'vue'
import { RouterLink } from 'vue-router'

const renderIcon = (icon: Component) => () => h(NIcon, null, { default: () => h(icon) })
const menuOptions: MenuOption[] = [
  {
    label: () => h(RouterLink, {
      to: {
        path: '/message/game',
      },
    },
    { default: () => '对战结果' },
    ),
    key: 'gameResult',
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
  <n-scrollbar class="scrollbar">
    <div style=" margin-top: 20px;text-align: center; font-weight: bold">
      消息中心
    </div>
    <n-divider />
    <n-menu :options="menuOptions" style="text-align: center" :root-indent="16" />
  </n-scrollbar>
</template>

<style scoped>
</style>

<style>
.scrollbar {
  width: 180px;
}
</style>
