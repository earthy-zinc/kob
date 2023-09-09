<script setup lang="ts">
import { APP_LAYOUT_PARAMS } from '~/config'

const {
  navHeight,
  contentPadding,
  footHeight,
} = APP_LAYOUT_PARAMS
</script>

<template>
  <n-scrollbar
    :style="{
      maxHeight: `calc(100vh - ${navHeight + contentPadding * 2 + footHeight + 22 * 2}px)`,
      minWidth: `600px`,
    }"
  >
    <div text-center style="font-size: medium; font-weight: bold">
      系统消息
    </div>
    <n-divider style="margin-top: 16px" />
    <n-list hoverable clickable>
      <n-list-item>
        <n-thing title="好友请求" title-extra="2023-6-5 10:25:04" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              <strong>兴奋的大母猴</strong> 请求添加您为好友
            </div>
            <div>
              <n-button type="tertiary" size="tiny" disabled style="margin-right: 10px">
                已接受
              </n-button>
            </div>
          </div>
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="违规警告" title-extra="2023-6-5 09:03:29" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              系统检测到您有 <strong>非法使用外挂插件</strong> 的行为，给予信用分 5 分警告
            </div>
          </div>
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="好友请求" title-extra="2023-6-3 20:13:24" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              <strong>我与焚天</strong> 请求添加您为好友
            </div>
            <div>
              <n-button type="info" size="tiny" style="margin-right: 10px">
                接受
              </n-button>
              <n-button type="info" size="tiny">
                拒绝
              </n-button>
            </div>
          </div>
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="好友请求" title-extra="2023-5-5 09:00:04" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              <strong>马云</strong> 请求添加您为好友
            </div>
            <div>
              <n-button type="info" size="tiny" style="margin-right: 10px">
                接受
              </n-button>
              <n-button type="info" size="tiny">
                拒绝
              </n-button>
            </div>
          </div>
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="好友请求" title-extra="2023-6-1 10:25:04" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              <strong>兴奋的大母猴</strong> 请求添加您为好友
            </div>
            <div>
              <n-button type="info" size="tiny" style="margin-right: 10px">
                接受
              </n-button>
              <n-button type="info" size="tiny">
                拒绝
              </n-button>
            </div>
          </div>
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="好友请求" title-extra="2023-6-5 10:25:04" content-style="margin-top: 10px;">
          <div style="display: flex; justify-content: space-between">
            <div>
              <strong>兴奋的大母猴</strong> 请求添加您为好友
            </div>
            <div>
              <n-button type="info" size="tiny" style="margin-right: 10px">
                接受
              </n-button>
              <n-button type="info" size="tiny">
                拒绝
              </n-button>
            </div>
          </div>
        </n-thing>
      </n-list-item>
    </n-list>
  </n-scrollbar>
</template>

<style scoped>

</style>
