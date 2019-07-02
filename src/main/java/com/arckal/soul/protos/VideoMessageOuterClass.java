// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VideoMessage.proto

package com.arckal.soul.protos;

public final class VideoMessageOuterClass {
  private VideoMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface VideoMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.arckal.soul.VideoMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string remoteUrl = 1;</code>
     */
    java.lang.String getRemoteUrl();
    /**
     * <code>string remoteUrl = 1;</code>
     */
    com.google.protobuf.ByteString
        getRemoteUrlBytes();

    /**
     * <code>int32 width = 2;</code>
     */
    int getWidth();

    /**
     * <code>int32 height = 3;</code>
     */
    int getHeight();
  }
  /**
   * Protobuf type {@code com.arckal.soul.VideoMessage}
   */
  public  static final class VideoMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.arckal.soul.VideoMessage)
      VideoMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use VideoMessage.newBuilder() to construct.
    private VideoMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private VideoMessage() {
      remoteUrl_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new VideoMessage();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private VideoMessage(
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

              remoteUrl_ = s;
              break;
            }
            case 16: {

              width_ = input.readInt32();
              break;
            }
            case 24: {

              height_ = input.readInt32();
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
      return com.arckal.soul.protos.VideoMessageOuterClass.internal_static_com_arckal_soul_VideoMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.arckal.soul.protos.VideoMessageOuterClass.internal_static_com_arckal_soul_VideoMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.class, com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.Builder.class);
    }

    public static final int REMOTEURL_FIELD_NUMBER = 1;
    private volatile java.lang.Object remoteUrl_;
    /**
     * <code>string remoteUrl = 1;</code>
     */
    public java.lang.String getRemoteUrl() {
      java.lang.Object ref = remoteUrl_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        remoteUrl_ = s;
        return s;
      }
    }
    /**
     * <code>string remoteUrl = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRemoteUrlBytes() {
      java.lang.Object ref = remoteUrl_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        remoteUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int WIDTH_FIELD_NUMBER = 2;
    private int width_;
    /**
     * <code>int32 width = 2;</code>
     */
    public int getWidth() {
      return width_;
    }

    public static final int HEIGHT_FIELD_NUMBER = 3;
    private int height_;
    /**
     * <code>int32 height = 3;</code>
     */
    public int getHeight() {
      return height_;
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
      if (!getRemoteUrlBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, remoteUrl_);
      }
      if (width_ != 0) {
        output.writeInt32(2, width_);
      }
      if (height_ != 0) {
        output.writeInt32(3, height_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getRemoteUrlBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, remoteUrl_);
      }
      if (width_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, width_);
      }
      if (height_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, height_);
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
      if (!(obj instanceof com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage)) {
        return super.equals(obj);
      }
      com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage other = (com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage) obj;

      if (!getRemoteUrl()
          .equals(other.getRemoteUrl())) return false;
      if (getWidth()
          != other.getWidth()) return false;
      if (getHeight()
          != other.getHeight()) return false;
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
      hash = (37 * hash) + REMOTEURL_FIELD_NUMBER;
      hash = (53 * hash) + getRemoteUrl().hashCode();
      hash = (37 * hash) + WIDTH_FIELD_NUMBER;
      hash = (53 * hash) + getWidth();
      hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getHeight();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parseFrom(
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
    public static Builder newBuilder(com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage prototype) {
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
     * Protobuf type {@code com.arckal.soul.VideoMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.arckal.soul.VideoMessage)
        com.arckal.soul.protos.VideoMessageOuterClass.VideoMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.arckal.soul.protos.VideoMessageOuterClass.internal_static_com_arckal_soul_VideoMessage_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.arckal.soul.protos.VideoMessageOuterClass.internal_static_com_arckal_soul_VideoMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.class, com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.Builder.class);
      }

      // Construct using com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.newBuilder()
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
        remoteUrl_ = "";

        width_ = 0;

        height_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.arckal.soul.protos.VideoMessageOuterClass.internal_static_com_arckal_soul_VideoMessage_descriptor;
      }

      @java.lang.Override
      public com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage getDefaultInstanceForType() {
        return com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.getDefaultInstance();
      }

      @java.lang.Override
      public com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage build() {
        com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage buildPartial() {
        com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage result = new com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage(this);
        result.remoteUrl_ = remoteUrl_;
        result.width_ = width_;
        result.height_ = height_;
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
        if (other instanceof com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage) {
          return mergeFrom((com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage other) {
        if (other == com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage.getDefaultInstance()) return this;
        if (!other.getRemoteUrl().isEmpty()) {
          remoteUrl_ = other.remoteUrl_;
          onChanged();
        }
        if (other.getWidth() != 0) {
          setWidth(other.getWidth());
        }
        if (other.getHeight() != 0) {
          setHeight(other.getHeight());
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
        com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object remoteUrl_ = "";
      /**
       * <code>string remoteUrl = 1;</code>
       */
      public java.lang.String getRemoteUrl() {
        java.lang.Object ref = remoteUrl_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          remoteUrl_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string remoteUrl = 1;</code>
       */
      public com.google.protobuf.ByteString
          getRemoteUrlBytes() {
        java.lang.Object ref = remoteUrl_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          remoteUrl_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string remoteUrl = 1;</code>
       */
      public Builder setRemoteUrl(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        remoteUrl_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string remoteUrl = 1;</code>
       */
      public Builder clearRemoteUrl() {
        
        remoteUrl_ = getDefaultInstance().getRemoteUrl();
        onChanged();
        return this;
      }
      /**
       * <code>string remoteUrl = 1;</code>
       */
      public Builder setRemoteUrlBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        remoteUrl_ = value;
        onChanged();
        return this;
      }

      private int width_ ;
      /**
       * <code>int32 width = 2;</code>
       */
      public int getWidth() {
        return width_;
      }
      /**
       * <code>int32 width = 2;</code>
       */
      public Builder setWidth(int value) {
        
        width_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 width = 2;</code>
       */
      public Builder clearWidth() {
        
        width_ = 0;
        onChanged();
        return this;
      }

      private int height_ ;
      /**
       * <code>int32 height = 3;</code>
       */
      public int getHeight() {
        return height_;
      }
      /**
       * <code>int32 height = 3;</code>
       */
      public Builder setHeight(int value) {
        
        height_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 height = 3;</code>
       */
      public Builder clearHeight() {
        
        height_ = 0;
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


      // @@protoc_insertion_point(builder_scope:com.arckal.soul.VideoMessage)
    }

    // @@protoc_insertion_point(class_scope:com.arckal.soul.VideoMessage)
    private static final com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage();
    }

    public static com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VideoMessage>
        PARSER = new com.google.protobuf.AbstractParser<VideoMessage>() {
      @java.lang.Override
      public VideoMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new VideoMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<VideoMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VideoMessage> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.arckal.soul.protos.VideoMessageOuterClass.VideoMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_arckal_soul_VideoMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_arckal_soul_VideoMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022VideoMessage.proto\022\017com.arckal.soul\"@\n" +
      "\014VideoMessage\022\021\n\tremoteUrl\030\001 \001(\t\022\r\n\005widt" +
      "h\030\002 \001(\005\022\016\n\006height\030\003 \001(\005B\030\n\026com.arckal.so" +
      "ul.protosb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_arckal_soul_VideoMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_arckal_soul_VideoMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_arckal_soul_VideoMessage_descriptor,
        new java.lang.String[] { "RemoteUrl", "Width", "Height", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}