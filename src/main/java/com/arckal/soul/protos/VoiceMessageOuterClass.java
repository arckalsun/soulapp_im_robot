// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VoiceMessage.proto

package com.arckal.soul.protos;

public final class VoiceMessageOuterClass {
  private VoiceMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface VoiceMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.arckal.soul.VoiceMessage)
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
     * <code>int32 duration = 2;</code>
     */
    int getDuration();

    /**
     * <code>string word = 3;</code>
     */
    java.lang.String getWord();
    /**
     * <code>string word = 3;</code>
     */
    com.google.protobuf.ByteString
        getWordBytes();
  }
  /**
   * Protobuf type {@code com.arckal.soul.VoiceMessage}
   */
  public  static final class VoiceMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.arckal.soul.VoiceMessage)
      VoiceMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use VoiceMessage.newBuilder() to construct.
    private VoiceMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private VoiceMessage() {
      remoteUrl_ = "";
      word_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new VoiceMessage();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private VoiceMessage(
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

              duration_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              word_ = s;
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
      return com.arckal.soul.protos.VoiceMessageOuterClass.internal_static_com_arckal_soul_VoiceMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.arckal.soul.protos.VoiceMessageOuterClass.internal_static_com_arckal_soul_VoiceMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.class, com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.Builder.class);
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

    public static final int DURATION_FIELD_NUMBER = 2;
    private int duration_;
    /**
     * <code>int32 duration = 2;</code>
     */
    public int getDuration() {
      return duration_;
    }

    public static final int WORD_FIELD_NUMBER = 3;
    private volatile java.lang.Object word_;
    /**
     * <code>string word = 3;</code>
     */
    public java.lang.String getWord() {
      java.lang.Object ref = word_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        word_ = s;
        return s;
      }
    }
    /**
     * <code>string word = 3;</code>
     */
    public com.google.protobuf.ByteString
        getWordBytes() {
      java.lang.Object ref = word_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        word_ = b;
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
      if (!getRemoteUrlBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, remoteUrl_);
      }
      if (duration_ != 0) {
        output.writeInt32(2, duration_);
      }
      if (!getWordBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, word_);
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
      if (duration_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, duration_);
      }
      if (!getWordBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, word_);
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
      if (!(obj instanceof com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage)) {
        return super.equals(obj);
      }
      com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage other = (com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage) obj;

      if (!getRemoteUrl()
          .equals(other.getRemoteUrl())) return false;
      if (getDuration()
          != other.getDuration()) return false;
      if (!getWord()
          .equals(other.getWord())) return false;
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
      hash = (37 * hash) + DURATION_FIELD_NUMBER;
      hash = (53 * hash) + getDuration();
      hash = (37 * hash) + WORD_FIELD_NUMBER;
      hash = (53 * hash) + getWord().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parseFrom(
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
    public static Builder newBuilder(com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage prototype) {
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
     * Protobuf type {@code com.arckal.soul.VoiceMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.arckal.soul.VoiceMessage)
        com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.arckal.soul.protos.VoiceMessageOuterClass.internal_static_com_arckal_soul_VoiceMessage_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.arckal.soul.protos.VoiceMessageOuterClass.internal_static_com_arckal_soul_VoiceMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.class, com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.Builder.class);
      }

      // Construct using com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.newBuilder()
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

        duration_ = 0;

        word_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.arckal.soul.protos.VoiceMessageOuterClass.internal_static_com_arckal_soul_VoiceMessage_descriptor;
      }

      @java.lang.Override
      public com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage getDefaultInstanceForType() {
        return com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.getDefaultInstance();
      }

      @java.lang.Override
      public com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage build() {
        com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage buildPartial() {
        com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage result = new com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage(this);
        result.remoteUrl_ = remoteUrl_;
        result.duration_ = duration_;
        result.word_ = word_;
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
        if (other instanceof com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage) {
          return mergeFrom((com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage other) {
        if (other == com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage.getDefaultInstance()) return this;
        if (!other.getRemoteUrl().isEmpty()) {
          remoteUrl_ = other.remoteUrl_;
          onChanged();
        }
        if (other.getDuration() != 0) {
          setDuration(other.getDuration());
        }
        if (!other.getWord().isEmpty()) {
          word_ = other.word_;
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
        com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage) e.getUnfinishedMessage();
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

      private int duration_ ;
      /**
       * <code>int32 duration = 2;</code>
       */
      public int getDuration() {
        return duration_;
      }
      /**
       * <code>int32 duration = 2;</code>
       */
      public Builder setDuration(int value) {
        
        duration_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 duration = 2;</code>
       */
      public Builder clearDuration() {
        
        duration_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object word_ = "";
      /**
       * <code>string word = 3;</code>
       */
      public java.lang.String getWord() {
        java.lang.Object ref = word_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          word_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string word = 3;</code>
       */
      public com.google.protobuf.ByteString
          getWordBytes() {
        java.lang.Object ref = word_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          word_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string word = 3;</code>
       */
      public Builder setWord(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        word_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string word = 3;</code>
       */
      public Builder clearWord() {
        
        word_ = getDefaultInstance().getWord();
        onChanged();
        return this;
      }
      /**
       * <code>string word = 3;</code>
       */
      public Builder setWordBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        word_ = value;
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


      // @@protoc_insertion_point(builder_scope:com.arckal.soul.VoiceMessage)
    }

    // @@protoc_insertion_point(class_scope:com.arckal.soul.VoiceMessage)
    private static final com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage();
    }

    public static com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VoiceMessage>
        PARSER = new com.google.protobuf.AbstractParser<VoiceMessage>() {
      @java.lang.Override
      public VoiceMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new VoiceMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<VoiceMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VoiceMessage> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.arckal.soul.protos.VoiceMessageOuterClass.VoiceMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_arckal_soul_VoiceMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_arckal_soul_VoiceMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022VoiceMessage.proto\022\017com.arckal.soul\"A\n" +
      "\014VoiceMessage\022\021\n\tremoteUrl\030\001 \001(\t\022\020\n\010dura" +
      "tion\030\002 \001(\005\022\014\n\004word\030\003 \001(\tB\030\n\026com.arckal.s" +
      "oul.protosb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_arckal_soul_VoiceMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_arckal_soul_VoiceMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_arckal_soul_VoiceMessage_descriptor,
        new java.lang.String[] { "RemoteUrl", "Duration", "Word", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
