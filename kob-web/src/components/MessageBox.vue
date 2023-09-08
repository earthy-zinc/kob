<script setup lang="ts">

</script>

<template>
  <n-card>
    <n-tabs type="line" animated default-value="friendRequest">
      <n-tab-pane name="好友申请" tab="friendRequest">
        <n-list>
          <n-list-item>
            <template #prefix>
              <n-avatar>
                <img alt="头像" src="">
              </n-avatar>
            </template>
            <template #default>
              <div>消息内容</div>
            </template>
            <template #suffix>
              <button>同意</button>
              <button>拒绝</button>
            </template>
          </n-list-item>
        </n-list>
      </n-tab-pane>
    </n-tabs>
  </n-card>
</template>

<style scoped>

</style>
