<script setup lang="ts">
import SideBar from './components/SideBar/index.vue'
import { APP_LAYOUT_PARAMS } from '~/config'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS
</script>

<template>
  <div style="max-width: 1143px;" h-full>
    <n-card hoverable>
      <div
        class="message-container"
        flex justify-between :style="{
          minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 22 * 2}px)`,
        }"
      >
        <SideBar />
        <n-divider
          vertical :style="{
            minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 22 * 2}px)`,
          }"
        />
        <RouterView />
      </div>
    </n-card>
  </div>
</template>

<style scoped>
.message-container {
  n-divider {
    flex-grow: 0;
  }
}
</style>
