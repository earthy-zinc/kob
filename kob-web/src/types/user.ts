import type { AnyObject } from './global'

export interface User extends AnyObject {
  id?: number
  username?: string
  name?: string
  password?: string
  avatar?: string
  phone?: string
  email?: string
  rating?: number
  createTime?: Date
  mnemonic?: string // 添加助记词字段
}

export interface UserSecurity extends AnyObject {
  hasPassword?: boolean
  hasPhone?: boolean
  hasBilibili?: boolean
  hasGithub?: boolean
  hasQQ?: boolean
  hasWechat?: boolean
}
