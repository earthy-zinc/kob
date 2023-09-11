<script setup lang="ts">
import { APP_LAYOUT_PARAMS } from '~/config'
import ChatContentBar from '~/pages/message/components/Content/ChatContentBar.vue'
import type { Chat } from '~/types'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS

const chatList = reactive<Chat[]>([
  {
    id: 1,
    userId: 1,
    username: '兴奋的大母猴',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '真的吗，太好了！！！',
  },
  {
    id: 2,
    userId: 2,
    username: '我与焚天',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 0,
    latestMessage: '这是你说的啊，钱到手了37分成！！！',
  },
  {
    id: 3,
    userId: 3,
    username: '吃撑了才玩这个',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 0,
    latestMessage: '好无聊',
  },
  {
    id: 4,
    userId: 4,
    username: '^(oo)^傷痛儺免●﹏☉',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 87,
    latestMessage: '亼傢妚喓啦！！！沵め孑討厭Θ乌Θ乌 |_・)',
  },
  {
    id: 5,
    userId: 5,
    username: '网络少年',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 0,
    latestMessage: '真的吗，太好了！！！',
  },
  {
    id: 6,
    userId: 6,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
  {
    id: 7,
    userId: 7,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
  {
    id: 8,
    userId: 8,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
  {
    id: 9,
    userId: 9,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
  {
    id: 10,
    userId: 10,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
  {
    id: 11,
    userId: 11,
    username: '叫兽',
    avatar: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
    unreadMessageNumber: 1,
    latestMessage: '快来！',
  },
])

function fetchMessageList(userId: number) {
  // todo
}
</script>

<template>
  <div flex w-full>
    <n-scrollbar
      :style="{
        maxHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 48}px)`,
        maxWidth: `290px`,
        minWidth: '290px',
      }"
    >
      <n-list v-for="chat in chatList" :key="chat.id" hoverable clickable>
        <n-list-item :key="chat.id" @click="fetchMessageList(chat.userId)">
          <div flex items-center>
            <n-avatar
              round
              size="large"
              :src="chat.avatar"
              style="margin-right: 15px"
            />
            <div grow>
              <div style="font-weight: bolder; font-size: medium">
                {{ chat.username }}
              </div>
              <div flex justify-between items-center>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey; max-width: 170px;">
                  {{ chat.latestMessage }}
                </n-ellipsis>
                <n-badge :value="chat.unreadMessageNumber" :max="99" />
              </div>
            </div>
          </div>
        </n-list-item>
      </n-list>
    </n-scrollbar>
    <n-divider
      vertical
      :style="{
        minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 48}px)`,
        margin: 0,
      }"
    />
    <ChatContentBar />
  </div>
</template>

<style scoped>

</style>
