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
      对战结果
    </div>
    <n-divider style="margin-top: 16px" />
    <n-list hoverable clickable>
      <n-list-item>
        <n-thing title="匹配对局结果" title-extra="2023-6-8 22:35:04" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag :bordered="false" type="info" size="small">
                S17赛季
              </n-tag>
              <n-tag :bordered="false" type="info" size="small">
                仲夏之夜
              </n-tag>
            </n-space>
          </template>
          您与 <strong>兴奋的大母猴</strong> 的对局结果已经产生，结果为：<span style="color: red; font-weight: bolder">失败</span><br>
          下次再接再厉
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="人机对局结果" title-extra="2023-6-5 10:25:04" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag :bordered="false" type="info" size="small">
                困难
              </n-tag>
              <n-tag :bordered="false" type="info" size="small">
                仲夏之夜
              </n-tag>
            </n-space>
          </template>
          您与 <strong>人机(困难)</strong> 的对局结果已经产生，结果为：<span style="color: green; font-weight: bolder">成功</span><br>
          祝贺您取得胜利！
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="匹配对局结果" title-extra="2023-6-4 20:35:07" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag :bordered="false" type="info" size="small">
                S17赛季
              </n-tag>
              <n-tag :bordered="false" type="info" size="small">
                仲夏之夜
              </n-tag>
            </n-space>
          </template>
          您与 <strong>兴奋的大母猴</strong> 的对局结果已经产生，结果为：<span style="color: red; font-weight: bolder">失败</span><br>
          下次再接再厉
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="人机对局结果" title-extra="2023-5-8 12:35:04" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag :bordered="false" type="info" size="small">
                困难
              </n-tag>
              <n-tag :bordered="false" type="info" size="small">
                仲夏之夜
              </n-tag>
            </n-space>
          </template>
          您与 <strong>人机</strong> 的对局结果已经产生，结果为：<span style="color: green; font-weight: bolder">成功</span><br>
          祝贺您取得胜利！
        </n-thing>
      </n-list-item>
      <n-list-item>
        <n-thing title="匹配对局结果" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag :bordered="false" type="info" size="small">
                S17赛季
              </n-tag>
              <n-tag :bordered="false" type="info" size="small">
                仲夏之夜
              </n-tag>
            </n-space>
          </template>
          您与 <strong>兴奋的大母猴</strong> 的对局结果已经产生，结果为：<span style="color: red; font-weight: bolder">失败</span><br>
          下次再接再厉
        </n-thing>
      </n-list-item>
    </n-list>
  </n-scrollbar>
</template>

<style>
</style>
