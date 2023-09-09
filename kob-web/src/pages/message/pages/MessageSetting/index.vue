<script setup lang="ts">
import { APP_LAYOUT_PARAMS } from '~/config'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS
</script>

<template>
  <div class="content">
    <div>消息设置</div>
    <n-divider
      vertical :style="{
        minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 22 * 2}px)`,
      }"
    />
  </div>
</template>

<style scoped>
.content {
  width: 900px;
  display: flex;
}
</style>
