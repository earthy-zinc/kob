<script setup lang="ts">
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
  <div class="chat-header">
    {{ route.meta?.title }}
  </div>
  <n-divider style="margin: 0" />
</template>

<style scoped>
.chat-header {
  text-align: center;
  font-size: medium;
  font-weight: bold;
  height: 40px;
  line-height: 40px;
}
</style>
