import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/dish/list',
    method: 'get',
    params
  })
}


export function save(params) {
  return request({
    url: '/dish',
    method: 'post',
    data : params
  })
}

export function remove(id) {
  return request({
    url: '/dish',
    method: 'delete',
    params: {
      id: id
    }
  })
}

export function get(id) {
  return request({
    url: '/dish',
    method: 'get',
    params: {
      id: id
    }
  })
}
