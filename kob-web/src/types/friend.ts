import type { AnyObject } from '~/types/global'

export interface Friend extends AnyObject {
  id?: number
  username?: string
  name?: string
  avatar?: string
  rating?: number
  createTime?: Date
}

export interface Chat extends AnyObject {
  id: number
  userId: number
  username: string
  avatar: string
  unreadMessageNumber: number
  latestMessage: string
}

export interface Message extends AnyObject {
  id: number
  userId: number
  isMe: boolean
  word: string
}

export interface GameResult extends AnyObject {
  id: number
  /**
   * 1 为匹配
   * 2 为人机
   */
  type: number
  title: string
  time: Date
  tag: string[]
  opponentId: number
  opponent: string
  /**
   * 0 失败
   * 1 成功
   */
  resultCode: number
  result: string
}
