package com.myapp.controller

import com.myapp.model.Widget
import com.myapp.test.BaseTestCase
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.validation.BindException

import static org.junit.Assert.assertTrue
import static org.mockito.Mockito.*


class WidgetControllerTest extends BaseTestCase {

    @Autowired
    WidgetController controller


    @Test(expected = BindException.class) void testCreate_Exception() {

        Widget widget = new Widget()

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        controller.create(widget, result)

    }

    @Test void testCreate() {

        String testName = "${System.currentTimeMillis()}"

        Widget widget = dao.find("from Widget w where w.name = :name",[name: testName])

        Widget newWidget = new Widget(name: testName, description: 'widget is great')

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        controller.create(newWidget, result)

        widget = findByName(testName)

        assertTrue widget != null

    }

    @Test void test_list() {

        String testName = "${System.currentTimeMillis()}"
        Widget w = new Widget(name: testName, description: 'test')
        dao.save(w)

        List widgets = controller.list()

        assertTrue widgets.contains(w)

    }

    @Test void test_get() {

        String testName = "${System.currentTimeMillis()}"
        Widget widget = new Widget(name: testName, description: 'test')
        dao.save(widget)


        Widget widget2 = controller.get(widget.id)

        assertTrue widget2 != null

        assertTrue widget2 == widget

    }

    @Test(expected = BindException.class) void test_update_Exception() {

        Widget widget = new Widget()

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        controller.update(widget, 1, result)

    }

    @Test void test_update() {

        String testName = "${System.currentTimeMillis()}"

        Widget widget = new Widget(name: testName, description: 'widget is great')
        dao.save(widget)

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        widget.name = "Foo Bar"

        controller.update(widget, widget.id, result)

        Widget widget2 = findByName('Foo Bar')

        assertTrue widget2 != null
        assertTrue widget2.id == widget.id
    }

    @Test void test_delete() {

        String testName = "${System.currentTimeMillis()}"

        Widget widget = new Widget(name: testName, description: 'widget is great')
        dao.save(widget)

        controller.delete(widget.id)

        dao.flush()

        widget = dao.find(Widget.class,widget.id)

        assertTrue widget == null



    }

    Widget findByName(String name) {
        dao.find("from Widget w where w.name = :name",[name: name])
    }


}