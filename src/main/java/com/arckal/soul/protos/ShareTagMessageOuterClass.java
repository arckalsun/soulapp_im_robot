// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShareTagMessage.proto

package com.arckal.soul.protos;

public final class ShareTagMessageOuterClass {
  private ShareTagMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ShareTagMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.arckal.soul.ShareTagMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string tagId = 1;</code>
     */
    java.lang.String getTagId();
    /**
     * <code>string tagId = 1;</code>
     */
    com.google.protobuf.ByteString
        getTagIdBytes();

    /**
     * <code>string tagName = 2;</code>
     */
    java.lang.String getTagName();
    /**
     * <code>string tagName = 2;</code>
     */
    com.google.protobuf.ByteString
        getTagNameBytes();
  }
  /**
   * Protobuf type {@code com.arckal.soul.ShareTagMessage}
   */
  public  static final class ShareTagMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.arckal.soul.ShareTagMessage)
      ShareTagMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ShareTagMessage.newBuilder() to construct.
    private ShareTagMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ShareTagMessage() {
      tagId_ = "";
      tagName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ShareTagMessage();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ShareTagMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              tagId_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              tagName_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.arckal.soul.protos.ShareTagMessageOuterClass.internal_static_com_arckal_soul_ShareTagMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.arckal.soul.protos.ShareTagMessageOuterClass.internal_static_com_arckal_soul_ShareTagMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.class, com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.Builder.class);
    }

    public static final int TAGID_FIELD_NUMBER = 1;
    private volatile java.lang.Object tagId_;
    /**
     * <code>string tagId = 1;</code>
     */
    public java.lang.String getTagId() {
      java.lang.Object ref = tagId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tagId_ = s;
        return s;
      }
    }
    /**
     * <code>string tagId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTagIdBytes() {
      java.lang.Object ref = tagId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tagId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TAGNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object tagName_;
    /**
     * <code>string tagName = 2;</code>
     */
    public java.lang.String getTagName() {
      java.lang.Object ref = tagName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tagName_ = s;
        return s;
      }
    }
    /**
     * <code>string tagName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTagNameBytes() {
      java.lang.Object ref = tagName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tagName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getTagIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tagId_);
      }
      if (!getTagNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tagName_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTagIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tagId_);
      }
      if (!getTagNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tagName_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage)) {
        return super.equals(obj);
      }
      com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage other = (com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage) obj;

      if (!getTagId()
          .equals(other.getTagId())) return false;
      if (!getTagName()
          .equals(other.getTagName())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TAGID_FIELD_NUMBER;
      hash = (53 * hash) + getTagId().hashCode();
      hash = (37 * hash) + TAGNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTagName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.arckal.soul.ShareTagMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.arckal.soul.ShareTagMessage)
        com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.arckal.soul.protos.ShareTagMessageOuterClass.internal_static_com_arckal_soul_ShareTagMessage_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.arckal.soul.protos.ShareTagMessageOuterClass.internal_static_com_arckal_soul_ShareTagMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.class, com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.Builder.class);
      }

      // Construct using com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        tagId_ = "";

        tagName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.arckal.soul.protos.ShareTagMessageOuterClass.internal_static_com_arckal_soul_ShareTagMessage_descriptor;
      }

      @java.lang.Override
      public com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage getDefaultInstanceForType() {
        return com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.getDefaultInstance();
      }

      @java.lang.Override
      public com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage build() {
        com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage buildPartial() {
        com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage result = new com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage(this);
        result.tagId_ = tagId_;
        result.tagName_ = tagName_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage) {
          return mergeFrom((com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage other) {
        if (other == com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage.getDefaultInstance()) return this;
        if (!other.getTagId().isEmpty()) {
          tagId_ = other.tagId_;
          onChanged();
        }
        if (!other.getTagName().isEmpty()) {
          tagName_ = other.tagName_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object tagId_ = "";
      /**
       * <code>string tagId = 1;</code>
       */
      public java.lang.String getTagId() {
        java.lang.Object ref = tagId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tagId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tagId = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTagIdBytes() {
        java.lang.Object ref = tagId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          tagId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tagId = 1;</code>
       */
      public Builder setTagId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        tagId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tagId = 1;</code>
       */
      public Builder clearTagId() {
        
        tagId_ = getDefaultInstance().getTagId();
        onChanged();
        return this;
      }
      /**
       * <code>string tagId = 1;</code>
       */
      public Builder setTagIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        tagId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tagName_ = "";
      /**
       * <code>string tagName = 2;</code>
       */
      public java.lang.String getTagName() {
        java.lang.Object ref = tagName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tagName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tagName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTagNameBytes() {
        java.lang.Object ref = tagName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          tagName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tagName = 2;</code>
       */
      public Builder setTagName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        tagName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tagName = 2;</code>
       */
      public Builder clearTagName() {
        
        tagName_ = getDefaultInstance().getTagName();
        onChanged();
        return this;
      }
      /**
       * <code>string tagName = 2;</code>
       */
      public Builder setTagNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        tagName_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.arckal.soul.ShareTagMessage)
    }

    // @@protoc_insertion_point(class_scope:com.arckal.soul.ShareTagMessage)
    private static final com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage();
    }

    public static com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ShareTagMessage>
        PARSER = new com.google.protobuf.AbstractParser<ShareTagMessage>() {
      @java.lang.Override
      public ShareTagMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ShareTagMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ShareTagMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ShareTagMessage> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.arckal.soul.protos.ShareTagMessageOuterClass.ShareTagMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_arckal_soul_ShareTagMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_arckal_soul_ShareTagMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025ShareTagMessage.proto\022\017com.arckal.soul" +
      "\"1\n\017ShareTagMessage\022\r\n\005tagId\030\001 \001(\t\022\017\n\007ta" +
      "gName\030\002 \001(\tB\030\n\026com.arckal.soul.protosb\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_arckal_soul_ShareTagMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_arckal_soul_ShareTagMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_arckal_soul_ShareTagMessage_descriptor,
        new java.lang.String[] { "TagId", "TagName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
