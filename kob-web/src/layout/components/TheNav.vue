<script setup lang="ts">
import { NButton } from 'naive-ui'
import { NavAvatar, NavLogo, NavMenu, NavResponsivePanel } from './nav-items'
import { useMessageStore } from '~/store/message'
import { $message } from '~/composables/tools'
import { APP_META } from '~/config'

const { isMobile } = useResponsive()
const development = isDevelopment
const { setMessageNum } = useMessageStore()
const { messageNum } = storeToRefs(useMessageStore())

const handleMessagePopover = () => {
  const notice = $notification.create({
    title: '好友请求',
    content: '兴奋的大母猴 请求添加您为好友',
    meta: '2023-9-9 12:11',
    closable: false,
    action: () => {
      const btnArray = [
        h(
          NButton,
          {
            text: true,
            type: 'primary',
            onClick: () => {
              $message.info('成功添加为好友')
              setMessageNum(0)
              notice.destroy()
            },
          },
          {
            default: () => '接收',
          },
        ),
        h(
          NButton,
          {
            text: true,
            type: 'warning',
            style: { marginLeft: '10px' },
            onClick: () => {
              $message.info('已拒绝添加为好友')
              setMessageNum(0)
              notice.destroy()
            },
          },
          {
            default: () => '拒绝',
          },
        ),
      ]
      return h('div', {}, btnArray)
    },
  })
}
</script>

<template>
  <div flex-y-center>
    <NavLogo ml6 />
    <NavMenu v-if="!isMobile" mx-5 />
    <div flex-auto />
    <div v-if="!isMobile" flex-y-center mr-10>
      <div i-carbon-debug icon-btn text-lg mx-5 @click="$router.push('/changelog')" />
      <a
        v-if="development"
        icon-btn text-lg i-uil-github-alt mr-5
        :href="APP_META.github"
        target="_blank" title="GitHub"
      />
      <n-badge :value="messageNum as number" :max="99">
        <div icon-btn text-lg i-ion-notifications-outline @click="handleMessagePopover" />
      </n-badge>
      <DarkToggle ml-5 mr-5 />
      <NavAvatar />
    </div>
    <NavResponsivePanel v-if="isMobile" />
  </div>
</template>
