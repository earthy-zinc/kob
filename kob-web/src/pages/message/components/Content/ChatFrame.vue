<script setup lang="ts">
defineProps({
  avatar: {
    type: String,
    default: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
  },
  chatContent: String,
  isMe: {
    type: Boolean,
    default: false,
  },
  dblclickAvatar: {
    type: Function,
    default: () => $notification.info({
      content: '你拍了拍Ta',
      duration: 2000,
    }),
  },
})
</script>

<template>
  <div class="chat-frame">
    <n-avatar
      :class="{ 'chat-avatar': !isMe, 'chat-avatar-is-me': isMe }"
      class="avatar"
      round
      size="large"
      :src="avatar"
      @dblclick="dblclickAvatar"
    />
    <div :class="{ 'chat-bar': !isMe, 'chat-bar-is-me': isMe }">
      <div class="chat-info">
        {{ chatContent }}
      </div>
    </div>
  </div>
</template>

<style scoped>
.chat-frame {
  display: grid;
  grid-template-columns:minmax(50px, 50px) repeat(4, minmax(0, 1fr)) minmax(50px, 50px);
  align-items: center;
  margin-left: 0.75rem;
  margin-bottom: 1rem;
  padding-right: 1.5rem;
}
.chat-avatar {
  grid-area: 1 / 1 / span 1/span 1;
}
.chat-avatar-is-me {
  grid-area: 1 / 6 / span 1 / span 1;
  justify-self: flex-end;
}
.avatar {
  transition: box-shadow;
}
.avatar:hover {
  box-shadow: var(--n-box-shadow);
  cursor: pointer;
}
.chat-bar {
  grid-area: 1 / 2 / span 1/span 5;
  max-width: 80%;
}
.chat-bar-is-me {
  grid-area: 1 / 1 / span 1/span 5;
  justify-self: end;
  max-width: 80%;
}
.chat-info {
  display: inline-block;
  border: 1px var(--n-border-color) solid;
  transition: box-shadow;
  border-radius: var(--n-border-radius);
  padding: 0.5rem 1rem;
  line-height: 30px;
  min-height: 30px;
  background-color: var(--n-color-embedded);
}
.chat-info:hover {
  box-shadow: var(--n-box-shadow);
}
</style>
