#!/bin/bash

# Android APK构建脚本 - 直接使用命令行构建
set -e

echo "===== 命令行构建Android APK ====="

# 检查Java环境
if ! command -v java &> /dev/null; then
    echo "❌ 错误: 未找到Java。请确保已安装JDK 11或17。"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -1 | awk -F[\"_] '{print $2}')
echo "✅ Java版本: $JAVA_VERSION"

# 检查Android SDK路径
SDK_PATH="/Users/wujun/Library/Android/sdk"
if [ ! -d "$SDK_PATH" ]; then
    echo "⚠️ 警告: Android SDK路径不存在: $SDK_PATH"
    echo "请确保Android SDK已正确安装"
else
    echo "✅ Android SDK路径有效"
fi

# 设置必要的环境变量
export ANDROID_HOME="$SDK_PATH"
export PATH="$SDK_PATH/platform-tools:$PATH"
export PATH="$SDK_PATH/tools:$PATH"

# 创建gradle-wrapper目录（如果不存在）
mkdir -p gradle/wrapper

# 创建gradle-wrapper.properties
cat > gradle/wrapper/gradle-wrapper.properties << 'EOF'
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.4-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
EOF

echo "✅ 已配置Gradle包装器（版本8.2）"

# 确保gradlew有执行权限
chmod +x gradlew 2>/dev/null || true

echo "🔨 开始执行构建命令: ./gradlew assembleDebug"
echo "📋 这将构建Debug版本的APK，首次运行可能需要下载依赖..."

# 执行实际的构建命令
cd /Users/wujun/python/谁是卧底/android_project
./gradlew clean assembleDebug

# 检查构建结果
if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
    echo "✅ APK构建成功！"
    echo "📁 APK文件位置: app/build/outputs/apk/debug/app-debug.apk"
    echo "\n🚀 可以使用以下命令安装到设备:"
    echo "   adb install app/build/outputs/apk/debug/app-debug.apk"
else
    echo "❌ APK构建失败或文件不存在"
    echo "📋 请检查构建输出中的错误信息"
    exit 1
fi

echo "\n🎉 构建完成！"