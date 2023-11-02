import { Token } from '~/utils'

const formatSocketUrl = () => {
  const urlPrefix = import.meta.env.VITE_BASE_SOCKET_URL
  return new URL(`/websocket/${Token.get()}/`, urlPrefix)
}

export function useSocket(onmessage: (msg: any) => void) {
  const pkStore = usePkStore()
  const socket = new WebSocket(formatSocketUrl())

  socket.onopen = () => pkStore.updateSocket(socket)
  socket.onmessage = onmessage
  socket.onerror = err => console.error(err, 'websocket连接失败')
  socket.onclose = () => {}

  return socket
}
