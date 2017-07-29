package com.lapots.breed.platform.json.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Configuration_QNAME = new QName("http://json.config.ns", "configuration");
    private final static QName _Data_QNAME = new QName("http://json.config.ns", "data");
    private final static QName _Converter_QNAME = new QName("http://json.config.ns", "converter");
    private final static QName _DomainClass_QNAME = new QName("http://json.config.ns", "domain-class");
    private final static QName _RepositoryClass_QNAME = new QName("http://json.config.ns", "repository-class");
    private final static QName _Entry_QNAME = new QName("http://json.config.ns", "entry");
    private final static QName _FromClass_QNAME = new QName("http://json.config.ns", "from-class");
    private final static QName _Entries_QNAME = new QName("http://json.config.ns", "entries");
    private final static QName _ToClass_QNAME = new QName("http://json.config.ns", "to-class");
    private final static QName _FilePath_QNAME = new QName("http://json.config.ns", "file-path");
    private final static QName _Label_QNAME = new QName("http://json.config.ns", "label");
    private final static QName _Converters_QNAME = new QName("http://json.config.ns", "converters");

    public ObjectFactory() {
    }

    public XmlConfigurationEntry createXmlConfigurationEntry() {
        return new XmlConfigurationEntry();
    }

    public XmlConfigurationEntries createXmlConfigurationEntries() {
        return new XmlConfigurationEntries();
    }

    public XmlConfigurationData createXmlConfigurationData() {
        return new XmlConfigurationData();
    }

    public XmlJsonConfiguration createXmlJsonConfiguration() {
        return new XmlJsonConfiguration();
    }

    public XmlJsonConverter createXmlJsonConverter() {
        return new XmlJsonConverter();
    }

    public XmlJsonConverters createXmlJsonConverters() {
        return new XmlJsonConverters();
    }

    public XmlConfigurationFilePath createXmlConfigurationFilePath() {
        return new XmlConfigurationFilePath();
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "configuration")
    public JAXBElement<XmlJsonConfiguration> createConfiguration(XmlJsonConfiguration value) {
        return new JAXBElement<XmlJsonConfiguration>(_Configuration_QNAME, XmlJsonConfiguration.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "data")
    public JAXBElement<XmlConfigurationData> createData(XmlConfigurationData value) {
        return new JAXBElement<XmlConfigurationData>(_Data_QNAME, XmlConfigurationData.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "converter")
    public JAXBElement<XmlJsonConverter> createConverter(XmlJsonConverter value) {
        return new JAXBElement<XmlJsonConverter>(_Converter_QNAME, XmlJsonConverter.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "domain-class")
    public JAXBElement<String> createDomainClass(String value) {
        return new JAXBElement<String>(_DomainClass_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "repository-class")
    public JAXBElement<String> createRepositoryClass(String value) {
        return new JAXBElement<String>(_RepositoryClass_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "entry")
    public JAXBElement<XmlConfigurationEntry> createEntry(XmlConfigurationEntry value) {
        return new JAXBElement<XmlConfigurationEntry>(_Entry_QNAME, XmlConfigurationEntry.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "from-class")
    public JAXBElement<String> createFromClass(String value) {
        return new JAXBElement<String>(_FromClass_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "entries")
    public JAXBElement<XmlConfigurationEntries> createEntries(XmlConfigurationEntries value) {
        return new JAXBElement<XmlConfigurationEntries>(_Entries_QNAME, XmlConfigurationEntries.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "to-class")
    public JAXBElement<String> createToClass(String value) {
        return new JAXBElement<String>(_ToClass_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "file-path")
    public JAXBElement<XmlConfigurationFilePath> createFilePath(XmlConfigurationFilePath value) {
        return new JAXBElement<XmlConfigurationFilePath>(_FilePath_QNAME, XmlConfigurationFilePath.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "label")
    public JAXBElement<String> createLabel(String value) {
        return new JAXBElement<String>(_Label_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://json.config.ns", name = "converters")
    public JAXBElement<XmlJsonConverters> createConverters(XmlJsonConverters value) {
        return new JAXBElement<XmlJsonConverters>(_Converters_QNAME, XmlJsonConverters.class, null, value);
    }

}
