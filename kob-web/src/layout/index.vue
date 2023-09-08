<script  setup lang="ts">
import TheNav from './components/TheNav.vue'
import TheContent from './components/TheContent.vue'
import TheFoot from './components/TheFoot.vue'
import { usePkStore } from '~/store/pk'
import { APP_LAYOUT_PARAMS } from '~/config'

const { isReady } = storeToRefs(usePkStore())
const {
  navHeight,
  contentPadding,
  footHeight,
  backTopRight,
  backTopBottom,
  backTopVisibilityHeight,
} = APP_LAYOUT_PARAMS

// 设置 `backTop` 的监听目标
const refWrapper = ref()
</script>

<template>
  <n-layout hw-screen of-hidden>
    <n-layout-header v-show="!isReady" bordered position="absolute">
      <TheNav w-full :style="{ height: `${navHeight}px` }" />
    </n-layout-header>
    <n-layout
      ref="refWrapper"
      position="absolute"
      :style="{
        height: 'auto',
        marginTop: `${navHeight + 1}px`,
        marginBottom: `${footHeight + 1}px`,
        minHeight: `calc(100vh - ${navHeight + 1 + footHeight + 1}px)`,
      }"
      :native-scrollbar="true"
    >
      <n-layout-content position="absolute">
        <TheContent
          :style="{
            padding: `${contentPadding}px`,
          }"
        />
      </n-layout-content>
      <n-back-top
        :listen-to="refWrapper"
        :right="backTopRight"
        :bottom="backTopBottom"
        :visibility-height="backTopVisibilityHeight"
      />
    </n-layout>
    <n-layout-footer
      v-show="!isReady"
      bordered position="absolute"
      :style="{ height: `${footHeight}px` }"
    >
      <TheFoot hw-full />
    </n-layout-footer>
  </n-layout>
</template>
