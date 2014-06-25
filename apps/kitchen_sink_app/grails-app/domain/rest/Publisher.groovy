package rest

import grails.rest.Resource

// @Resource(uri = '/api/publishers')
class Publisher {
    String name
    Map books // Map ISBN:Book name
}
