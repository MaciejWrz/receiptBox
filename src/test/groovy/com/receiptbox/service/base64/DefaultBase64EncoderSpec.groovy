package com.receiptbox.service.base64

import org.apache.commons.codec.binary.Base64
import org.bson.types.Binary
import spock.lang.Specification
import spock.lang.Subject

@Subject(DefaultBase64Encoder)
class DefaultBase64EncoderSpec extends Specification{
    def 'should encode data when Binary argument is received'() {
        given:
        def testData = 'sample text'
        def encodedTestData

        when:
        encodedTestData = new DefaultBase64Encoder().encode(new Binary(testData.bytes))

        then:
        new String(new Base64().decode(encodedTestData)) == testData
    }

    def 'should not fail when null is passed to the encoder'() {
        when:
        new DefaultBase64Encoder().encode(null)

        then:
        noExceptionThrown()
    }
}
