package com.myapp.controller

import com.myapp.model.Widget
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping


import org.springframework.http.HttpStatus


import org.springframework.validation.BindException

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import javax.annotation.PostConstruct

import javax.validation.Valid


@Controller
@RequestMapping("/widget")
class WidgetController extends BaseController {

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody List list() {

        dao.query("from Widget w")
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody Widget get(@PathVariable Long id) {

        dao.find(Widget.class, id)

    }


    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody Widget create(@RequestBody @Valid Widget widget, BindingResult result) {

        if(result.hasErrors())
            throw new BindException(result)

        if(widget.imageUrl == null)
            widget.imageUrl = 'http://zachwill.github.io/hn/img/octocat.png'

        dao.save(widget)

        widget
    }

    @RequestMapping(value="/{id}",method=RequestMethod.POST)
    @ResponseBody Widget update(@RequestBody @Valid Widget widget, @PathVariable Long id, BindingResult result) {

        if(result.hasErrors())
            throw new BindException(result)

        dao.merge(widget)

        widget
    }


    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long id) {

        dao.remove(Widget.class,id)

    }
	


    @PostConstruct
    void initializeWidgets() {

        List widgets = [[ name: 'Widget A', description: 'Unicorn', imageUrl: 'http://www.easy-drawings-and-sketches.com/images/how-to-draw-a-unicorn09.jpg'],
                        [ name: 'Widget B', description: 'Good Guys', imageUrl: 'http://gorightly.files.wordpress.com/2008/01/jesus-elvis.jpg'],
                        [ name: 'Widget C', description: 'Elvis', imageUrl: 'http://www.thevelvetstore.com/Merchant2/graphics/00000001/ve038-1.jpg']]

        widgets.each {
            initializeWidget(it)
        }

    }

    Widget initializeWidget(Map params) {

        Widget w = dao.find("from Widget w where w.name = :name",[name: params.name])
        if(w)
           return w


        w = new Widget(params)

        dao.save(w)

        return w
    }

	
}