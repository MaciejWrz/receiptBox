package com.receiptbox.service.base64

import spock.lang.Specification
import spock.lang.Subject
import org.apache.commons.codec.binary.Base64

@Subject(DefaultBase64Decoder)
class DefaultBase64DecoderSpec extends Specification {

    def 'should decode encoded data when base64 encoded string is received'() {
        given:
        def testData = 'sample text'
        def encodedTestData = new Base64().encodeAsString(testData.getBytes())
        def decodedTestData

        when:
        decodedTestData = new DefaultBase64Decoder().decode(encodedTestData)

        then:
        new String(decodedTestData) == testData
    }

    def 'should not fail when null is passed to the decoder'() {
        when:
        new DefaultBase64Decoder().decode(null)

        then:
        noExceptionThrown()
    }
}
