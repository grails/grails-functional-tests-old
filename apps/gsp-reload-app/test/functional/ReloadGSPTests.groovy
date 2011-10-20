import geb.junit4.GebReportingTest
import org.junit.Test
import static org.junit.Assert.*
import java.io.File
import grails.util.Environment

class ReloadGSPTests extends GebReportingTest {
    @Test
    void testReloading() {
        assert Environment.current == Environment.PRODUCTION
        to HelloPage
        assert heading == 'Hello'
        assert message == 'Hello world'
        
        File gspFile = new File("target/work/war/WEB-INF/grails-app/views/hello/index.gsp")
        def oldContent = gspFile.text
        def newContent = '''<html>
<head><title>Hello</title></head>
<body>
<h1>Reloaded Hello</h1>
<div class="message">Hello new world</div>
</body>
</html>'''
        gspFile.text = newContent
        // wait 2 * default timeout
        Thread.sleep(10000L)
        to HelloPage
        assert heading == 'Reloaded Hello'
        assert message == 'Hello new world'
                
        def newContentWithLayout = '''<html>
        <head><meta name="layout" content="main"/><title>Hello</title></head>
        <body>
        <h1>Hello layout</h1>
        <div class="message">Hello world with layout</div>
        </body>
        </html>'''        
        gspFile.text = newContentWithLayout
        // wait 2 * default timeout
        Thread.sleep(10000L)
        to HelloPage
        assert heading == 'Hello layout'
        assert message == 'Hello world with layout'
        
        File layoutFile = new File("target/work/war/WEB-INF/grails-app/views/layouts/main.gsp")
        def layoutContent = layoutFile.text
        layoutFile.text = layoutContent + "<!--LAYOUT UPDATED-->"
        // wait 2 * default timeout
        Thread.sleep(10000L)
        to HelloPage
        assert browser.contains('<!--LAYOUT UPDATED-->')
    }
}

class HelloPage extends geb.Page {
    static url = "hello/index"
    
    static content = {
        heading { $("h1").text() }
	message { $("div.message").text() }
    }
}
