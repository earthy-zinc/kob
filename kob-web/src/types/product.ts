import type { AnyObject } from '~/types/global'

export interface Product extends AnyObject {
  id?: number
  prop_id?: number
  prop_name?: string
  prop_avatar?: string
  seller_id?: number
  seller_name?: string
  seller_avatar?: string
  description?: string
  priceUint?: string
  number?: number
  price?: number
  totalPrice?: number
  createTime?: Date
}
