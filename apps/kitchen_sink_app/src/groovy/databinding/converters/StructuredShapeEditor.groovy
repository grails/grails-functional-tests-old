package databinding.converters

import databinding.Shape

import org.grails.databinding.converters.AbstractStructuredBindingEditor

class StructuredShapeEditor extends AbstractStructuredBindingEditor<Shape> {

    public Shape getPropertyValue(Map values) {
        def width = values.width as int
        def height = values.height as int

        def area = width * height

        new Shape(area: area)
    }
}

