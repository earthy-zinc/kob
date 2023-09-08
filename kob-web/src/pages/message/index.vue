<script setup lang="ts">
import SideBar from './components/SideBar/index.vue'
import Content from './components/Content/index.vue'
import { APP_LAYOUT_PARAMS } from '~/config'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS
</script>

<template>
  <div w-full h-full>
    <n-card hoverable>
      <div
        class="message-container"
        flex w-full h-full :style="{
          minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 22 * 2}px)`,
        }"
      >
        <SideBar />
        <Content />
      </div>
    </n-card>
  </div>
</template>

<style scoped>
.message-container {
  justify-content: stretch;
  align-items: stretch;
  align-content: stretch;
}
</style>
