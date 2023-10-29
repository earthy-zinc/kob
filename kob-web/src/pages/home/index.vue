<script setup lang="ts">
const contentHeight = diffHeight

const emojiArray = [
  '\\(o_o)/',
  '(o^^)o',
  '(˚Δ˚)b',
  '(^-^*)',
  '(^_^)b',
  '(╯‵□′)╯',
  '(=\'X\'=)',
  '(>_<)',
  '\\(°ˊДˋ°)/',
  'ㄟ(▔▽▔)ㄏ',
]
const getEmoji = (): string =>
  emojiArray[Math.floor(Math.random() * emojiArray.length)]

onMounted(() => useLottie({
  containerId: '#lottie',
  path: 'https://assets7.lottiefiles.com/packages/lf20_znxtcbvh33.json',
}))
</script>

<template>
  <div
    w-70vw mx-a flex="col center"
    :style="{ height: `calc(100vh - ${contentHeight}px)` }"
  >
    <div id="lottie" w400px h300px mt10px />
    <div text-center font-bold mt="[-20px]">
      <h1 text="3xl" m="t-2 b-2">
        {{ getEmoji() }}，欢迎来到土味贪吃蛇
      </h1>
      <p text-2xl m="t-3 b-2" w-40vw mx-a>
        这是一个双人对战游戏，快去找一个小伙伴和你一起玩吧。当然你也可以和AI先练练手。
        蛇蛇会随着移动逐渐变长，注意游戏过程中不要碰到任何东西哦。
      </p>
    </div>
  </div>
</template>
