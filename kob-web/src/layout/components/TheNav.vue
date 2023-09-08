<script setup lang="ts">
import { NavAvatar, NavLogo, NavMenu, NavResponsivePanel } from './nav-items'
import { APP_META } from '~/config'

const { isMobile } = useResponsive()
const development = isDevelopment
const handleMessagePopover = () => {
  $notification.info({
    content: '点击了消息按钮',
    duration: 30 * 1000,
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
      <n-badge :value="384" :max="99">
        <div icon-btn text-lg i-ion-notifications-outline @click="handleMessagePopover" />
      </n-badge>
      <DarkToggle ml-5 mr-5 />
      <NavAvatar />
    </div>
    <NavResponsivePanel v-if="isMobile" />
  </div>
</template>
