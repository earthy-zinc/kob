<script setup lang="ts">
import type { ScrollbarInst } from 'naive-ui'
import { APP_LAYOUT_PARAMS } from '~/config'
import ChatFrame from '~/pages/message/components/Content/ChatFrame.vue'
import InputBar from '~/pages/message/components/Content/InputBar.vue'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS

const scrollbarInstRef = ref<ScrollbarInst>()

let a = 0
// eslint-disable-next-line prefer-const
let msgList = reactive<{ id: number; isMe: boolean; word: string }[]>([])

const sendMessage = (word: string) => {
  const text = unref(word)
  msgList.push({ id: a++, isMe: true, word: text })
  nextTick(() => scrollbarInstRef.value?.scrollTo({
    top: 10000,
  }))
}

onMounted(() => scrollbarInstRef.value?.scrollTo({
  top: 10000,
}))
</script>

<template>
  <n-scrollbar
    ref="scrollbarInstRef"
    :style="{
      maxHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 50 * 2}px - 125.8px)`,
    }"
  >
    <ChatFrame chat-content="这是聊天543这是聊天543这是聊这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543" />
    <ChatFrame is-me chat-content="这这是聊天543这是聊天543这是聊天543这天543这是聊天543这是聊天543这是聊天543" />
    <ChatFrame is-me chat-content="这这是聊天543这是聊天543这是聊天5443这是聊天543" />
    <ChatFrame chat-content="这是聊天543这是聊天543这是聊这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543" />
    <ChatFrame chat-content="这是聊天543这是聊天543这是聊这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543这是聊天543" />
    <div v-for="msg in msgList">
      <ChatFrame :key="msg.id" :is-me="msg.isMe" :chat-content="msg.word" />
    </div>
  </n-scrollbar>
  <InputBar @send-msg="sendMessage" />
</template>

<style scoped>
</style>
