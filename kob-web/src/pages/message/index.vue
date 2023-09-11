<script setup lang="ts">
import { APP_LAYOUT_PARAMS } from '~/config'
import DialogTopBar from '~/pages/message/components/Content/DialogTopBar.vue'
import SideBar from '~/pages/message/components/SideBar/index.vue'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS

const { isMobile } = useResponsive()
</script>

<template>
  <div h-full>
    <n-card
      hoverable
      class="message-container"
      :content-style="{
        'padding': 0,
        'max-height': `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 4}px)`,
        'min-height': `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 4}px)`,
        'display': 'grid',
        'grid-template-columns': 'repeat(6, minmax(0, 1fr))',
      }"
    >
      <div v-if="!isMobile" flex-center>
        <SideBar />
        <n-divider vertical style="height: 100%; margin: 0" />
      </div>
      <div :class="{ 'computer-view': !isMobile, 'mobile-view': isMobile }">
        <DialogTopBar />
        <RouterView
          :style=" {
            'max-height': `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 46}px)`,
            'min-height': `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 46}px)`,
          }"
        />
      </div>
    </n-card>
  </div>
</template>

<style scoped>
.message-container {
  @media (max-width: 1143px){
    width: 90vw;
  }
  @media (min-width: 1143px){
    width: 1140px;
  }
}
</style>

<style>
.computer-view {
  grid-column-start: 2;
  grid-column-end: 7;
}

.mobile-view {
  grid-column-start: 1;
  grid-column-end: 7;
}
</style>
