package autoflush

import grails.rest.Resource

@Resource
class Item implements Serializable {
    String title
    String description
}
