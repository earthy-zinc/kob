<script setup lang="ts">
import type { ScrollbarInst } from 'naive-ui'
import { APP_LAYOUT_PARAMS } from '~/config'
import ChatFrame from '~/pages/message/components/Content/ChatFrame.vue'
import InputBar from '~/pages/message/components/Content/InputBar.vue'
import type { Message } from '~/types'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS

const scrollbarInstRef = ref<ScrollbarInst>()

let a = 0
// eslint-disable-next-line prefer-const
let msgList = reactive<Message[]>([])

const sendMessage = (word: string) => {
  const text = unref(word)
  msgList.push({ id: a++, userId: 0, isMe: true, word: text })
  nextTick(() => scrollbarInstRef.value?.scrollTo({
    top: 10000,
  }))
}

onMounted(() => {
  const list: Message[] = [
    {
      id: 1,
      userId: 10,
      isMe: false,
      word: '你好呀',
    },
    {
      id: 2,
      userId: 1,
      isMe: true,
      word: '在在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛在干嘛干嘛',
    },
    {
      id: 3,
      userId: 10,
      isMe: false,
      word: '吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭吃饭',
    },
    {
      id: 4,
      userId: 1,
      isMe: true,
      word: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
    },
    {
      id: 5,
      userId: 10,
      isMe: false,
      word: '你手机打开规划哈克斯的乐观活泼会的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉的乐观活泼会卡归还借款北京克拉卡归还借款北京克拉斯帝国崩溃了吧爱德华感觉卡拉公开大皇宫考虑阿桑的歌回家看了',
    },
  ]
  msgList.push(...list)
  scrollbarInstRef.value?.scrollTo({
    top: 10000,
  })
})
</script>

<template>
  <div>
    <n-scrollbar
      ref="scrollbarInstRef"
      :style="{
        maxHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 90 * 2}px)`,
      }"
    >
      <div v-for="msg in msgList" :key="msg.id">
        <ChatFrame :key="msg.id" :is-me="msg.isMe" :chat-content="msg.word" />
      </div>
    </n-scrollbar>
    <InputBar @send-msg="sendMessage" />
  </div>
</template>

<style scoped>
</style>
