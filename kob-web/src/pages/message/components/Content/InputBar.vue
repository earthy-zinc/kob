<script setup lang="ts">
import { computed } from 'vue'
const emit = defineEmits(['sendMsg'])
// eslint-disable-next-line prefer-const
let word = ref('')
// eslint-disable-next-line prefer-const
let wordCount = computed(() => word.value.trim().length)
const sendMessage = () => {
  if (wordCount.value === 0) return
  if (wordCount.value > 500) return
  emit('sendMsg', word)
  nextTick(() => word.value = '')
}
</script>

<template>
  <div @keyup.shift.enter="sendMessage">
    <n-divider style="margin: 0 0 10px 0" />

    <n-input
      v-model:value="word"
      :autofocus="true"
      type="textarea"
      placeholder=""
    />

    <div flex justify-end mr-8>
      <div v-if="wordCount > 500" color-red mr-5 style="line-height: 34px;">
        超过当前可输入的最大字数
      </div>
      <div mr-5 style="line-height: 34px; color: rgb(128,128,128);">
        <span :class="{ 'color-red': wordCount > 500 }">{{ wordCount }}</span>/500
      </div>
      <n-popover trigger="hover" :delay="500" :duration="500">
        <template #trigger>
          <n-button @click="sendMessage">
            发送
          </n-button>
        </template>
        <span>按下 Enter 键可以换行，按下 Shift + Enter 键可以发送消息</span>
      </n-popover>
    </div>
  </div>
</template>

<style>
.n-input {
  background-color: transparent;
}
.n-input:not(.n-input--disabled).n-input--focus {
  background-color: transparent;
}
.n-input .n-input__border, .n-input .n-input__state-border {
  border: none;
}
.n-input.n-input--textarea.n-input--resizable .n-input-wrapper{
  resize: none;
}
.n-input:not(.n-input--disabled).n-input--focus .n-input__state-border {
  border: none;
  box-shadow: none;
}
.n-input:not(.n-input--disabled):hover .n-input__state-border {
  border: none;
}
</style>
