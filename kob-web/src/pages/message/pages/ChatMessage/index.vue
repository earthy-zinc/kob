<script setup lang="ts">
import { APP_LAYOUT_PARAMS } from '~/config'
import BlankMessageBody from '~/pages/message/components/Content/BlankMessageBody.vue'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS
</script>

<template>
  <div>
    <div text-center style="font-size: medium; font-weight: bold">
      聊天消息
    </div>
    <n-divider style="margin-top: 16px" />
    <div class="content">
      <n-scrollbar
        :style="{
          maxHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 50 * 2}px)`,
          maxWidth: `250px`,
        }"
      >
        <n-list hoverable clickable>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  兴奋的大母猴
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  真的吗，太好了！！！
                  <n-badge :value="2" :max="15" :offset="[10, -2]" />
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  我与焚天
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  这是你说的啊，钱到手了37分成！！！
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  吃撑了才玩这个
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  好无聊
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  ^(oo)^傷痛儺免●﹏☉
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  亼傢妚喓啦！！！沵め孑討厭Θ乌Θ乌 |_・)
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  网络少年
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  。。。。
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
          <n-list-item>
            <div flex items-center>
              <n-avatar
                round
                size="large"
                src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                style="margin-right: 15px"
              />
              <div>
                <div style="font-weight: bolder; font-size: medium">
                  叫兽
                </div>
                <n-ellipsis style="font-size: small; font-weight: lighter; color: grey">
                  不要怕，快来
                </n-ellipsis>
              </div>
            </div>
          </n-list-item>
        </n-list>
      </n-scrollbar>
      <n-divider
        vertical :style="{
          minHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 50 * 2}px)`,
        }"
      />
      <div style="min-width: 300px">
        <BlankMessageBody />
      </div>
    </div>
  </div>
</template>

<style scoped>
.content {
  width: 900px;
  display: flex;
}
</style>
