import type { AnyObject } from '~/types/global'

export interface Friend extends AnyObject {
  id?: number
  username?: string
  name?: string
  avatar?: string
  rating?: number
  createTime?: Date
}
