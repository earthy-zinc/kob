<script setup lang="ts">
import type { GameResult } from '~/types'

const gameResultList = reactive<GameResult[]>([
  {
    id: 1,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 2,
    type: 2,
    title: '人机对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 0,
    opponent: '人机（困难）',
    resultCode: 0,
    result: '失败',
  },
  {
    id: 3,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 4,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 5,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 6,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 7,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 8,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 9,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 10,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
  {
    id: 11,
    type: 1,
    title: '匹配对局结果',
    time: new Date(),
    tag: ['S17赛季', '仲夏之夜'],
    opponentId: 1,
    opponent: '兴奋的大母猴',
    resultCode: 1,
    result: '成功',
  },
])
</script>

<template>
  <n-scrollbar>
    <n-list hoverable clickable>
      <n-list-item v-for="gameResult in gameResultList" :key="gameResult.id">
        <n-thing :title="gameResult.title" :title-extra="gameResult.time.toLocaleDateString()" content-style="margin-top: 10px;">
          <template #description>
            <n-space size="small" style="margin-top: 4px">
              <n-tag v-for="(tag, index) in gameResult.tag" :key="index" :bordered="false" type="info" size="small">
                {{ tag }}
              </n-tag>
            </n-space>
          </template>
          您与 <strong>{{ gameResult.opponent }}</strong> 的对局结果已经产生，结果为：
          <span :class="{ win: gameResult.resultCode === 1, lose: gameResult.resultCode === 0 }">
            {{ gameResult.result }}
          </span><br>
          <span v-if="gameResult.resultCode === 1">
            祝贺您取得胜利！
          </span>
          <span v-else>
            下次再接再厉
          </span>
        </n-thing>
      </n-list-item>
    </n-list>
  </n-scrollbar>
</template>

<style scoped>
.win {
  color: green;
  font-weight: bolder;
}
.lose {
  color: red;
  font-weight: bolder;
}
</style>
