export const useMessageStore = defineStore(
  'messageStore',
  () => {
    let messageNum = $ref<number>(2)
    const setMessageNum = (num: number) => messageNum = num
    return $$({
      messageNum,
      setMessageNum,
    })
  },
  { persist: { enabled: true } },
)
