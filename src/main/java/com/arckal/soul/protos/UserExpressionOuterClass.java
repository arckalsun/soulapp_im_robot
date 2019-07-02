// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserExpression.proto

package com.arckal.soul.protos;

public final class UserExpressionOuterClass {
  private UserExpressionOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UserExpressionOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.arckal.soul.UserExpression)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string url = 1;</code>
     */
    java.lang.String getUrl();
    /**
     * <code>string url = 1;</code>
     */
    com.google.protobuf.ByteString
        getUrlBytes();
  }
  /**
   * Protobuf type {@code com.arckal.soul.UserExpression}
   */
  public  static final class UserExpression extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.arckal.soul.UserExpression)
      UserExpressionOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use UserExpression.newBuilder() to construct.
    private UserExpression(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private UserExpression() {
      url_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new UserExpression();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private UserExpression(
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

              url_ = s;
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
      return com.arckal.soul.protos.UserExpressionOuterClass.internal_static_com_arckal_soul_UserExpression_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.arckal.soul.protos.UserExpressionOuterClass.internal_static_com_arckal_soul_UserExpression_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.class, com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.Builder.class);
    }

    public static final int URL_FIELD_NUMBER = 1;
    private volatile java.lang.Object url_;
    /**
     * <code>string url = 1;</code>
     */
    public java.lang.String getUrl() {
      java.lang.Object ref = url_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        url_ = s;
        return s;
      }
    }
    /**
     * <code>string url = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUrlBytes() {
      java.lang.Object ref = url_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        url_ = b;
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
      if (!getUrlBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, url_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getUrlBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, url_);
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
      if (!(obj instanceof com.arckal.soul.protos.UserExpressionOuterClass.UserExpression)) {
        return super.equals(obj);
      }
      com.arckal.soul.protos.UserExpressionOuterClass.UserExpression other = (com.arckal.soul.protos.UserExpressionOuterClass.UserExpression) obj;

      if (!getUrl()
          .equals(other.getUrl())) return false;
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
      hash = (37 * hash) + URL_FIELD_NUMBER;
      hash = (53 * hash) + getUrl().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parseFrom(
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
    public static Builder newBuilder(com.arckal.soul.protos.UserExpressionOuterClass.UserExpression prototype) {
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
     * Protobuf type {@code com.arckal.soul.UserExpression}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.arckal.soul.UserExpression)
        com.arckal.soul.protos.UserExpressionOuterClass.UserExpressionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.arckal.soul.protos.UserExpressionOuterClass.internal_static_com_arckal_soul_UserExpression_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.arckal.soul.protos.UserExpressionOuterClass.internal_static_com_arckal_soul_UserExpression_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.class, com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.Builder.class);
      }

      // Construct using com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.newBuilder()
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
        url_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.arckal.soul.protos.UserExpressionOuterClass.internal_static_com_arckal_soul_UserExpression_descriptor;
      }

      @java.lang.Override
      public com.arckal.soul.protos.UserExpressionOuterClass.UserExpression getDefaultInstanceForType() {
        return com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.getDefaultInstance();
      }

      @java.lang.Override
      public com.arckal.soul.protos.UserExpressionOuterClass.UserExpression build() {
        com.arckal.soul.protos.UserExpressionOuterClass.UserExpression result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.arckal.soul.protos.UserExpressionOuterClass.UserExpression buildPartial() {
        com.arckal.soul.protos.UserExpressionOuterClass.UserExpression result = new com.arckal.soul.protos.UserExpressionOuterClass.UserExpression(this);
        result.url_ = url_;
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
        if (other instanceof com.arckal.soul.protos.UserExpressionOuterClass.UserExpression) {
          return mergeFrom((com.arckal.soul.protos.UserExpressionOuterClass.UserExpression)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.arckal.soul.protos.UserExpressionOuterClass.UserExpression other) {
        if (other == com.arckal.soul.protos.UserExpressionOuterClass.UserExpression.getDefaultInstance()) return this;
        if (!other.getUrl().isEmpty()) {
          url_ = other.url_;
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
        com.arckal.soul.protos.UserExpressionOuterClass.UserExpression parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.arckal.soul.protos.UserExpressionOuterClass.UserExpression) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object url_ = "";
      /**
       * <code>string url = 1;</code>
       */
      public java.lang.String getUrl() {
        java.lang.Object ref = url_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          url_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string url = 1;</code>
       */
      public com.google.protobuf.ByteString
          getUrlBytes() {
        java.lang.Object ref = url_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          url_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string url = 1;</code>
       */
      public Builder setUrl(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        url_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string url = 1;</code>
       */
      public Builder clearUrl() {
        
        url_ = getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      /**
       * <code>string url = 1;</code>
       */
      public Builder setUrlBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        url_ = value;
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


      // @@protoc_insertion_point(builder_scope:com.arckal.soul.UserExpression)
    }

    // @@protoc_insertion_point(class_scope:com.arckal.soul.UserExpression)
    private static final com.arckal.soul.protos.UserExpressionOuterClass.UserExpression DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.arckal.soul.protos.UserExpressionOuterClass.UserExpression();
    }

    public static com.arckal.soul.protos.UserExpressionOuterClass.UserExpression getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UserExpression>
        PARSER = new com.google.protobuf.AbstractParser<UserExpression>() {
      @java.lang.Override
      public UserExpression parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserExpression(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<UserExpression> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UserExpression> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.arckal.soul.protos.UserExpressionOuterClass.UserExpression getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_arckal_soul_UserExpression_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_arckal_soul_UserExpression_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024UserExpression.proto\022\017com.arckal.soul\"" +
      "\035\n\016UserExpression\022\013\n\003url\030\001 \001(\tB\030\n\026com.ar" +
      "ckal.soul.protosb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_arckal_soul_UserExpression_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_arckal_soul_UserExpression_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_arckal_soul_UserExpression_descriptor,
        new java.lang.String[] { "Url", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}