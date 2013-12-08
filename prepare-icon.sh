#!/bin/bash

SOURCE="${BASH_SOURCE[0]}"
while [ -h "$SOURCE" ]; do # resolve $SOURCE until the file is no longer a symlink
  DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
  SOURCE="$(readlink "$SOURCE")"
  [[ $SOURCE != /* ]] && SOURCE="$DIR/$SOURCE" # if $SOURCE was a relative symlink, we need to resolve it relative to the path where the symlink file was located
done
BASE_DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"

mkdir -p $BASE_DIR/res/drawable-ldpi/
mkdir -p $BASE_DIR/res/drawable-mdpi/
mkdir -p $BASE_DIR/res/drawable-hdpi/
mkdir -p $BASE_DIR/res/drawable-xhdpi/
#mkdir -p $BASE_DIR/res/drawable-xxdpi/
#mkdir -p $BASE_DIR/res/drawable-xxxdpi/

for ICON in $BASE_DIR/art/*.svg; do
	BASE_NAME=$(basename $ICON .svg)

	convert -background none -resize 36x36 $ICON $BASE_DIR/res/drawable-ldpi/$BASE_NAME.png
	convert -background none -resize 48x48 $ICON $BASE_DIR/res/drawable-mdpi/$BASE_NAME.png
	convert -background none -resize 72x72 $ICON $BASE_DIR/res/drawable-hdpi/$BASE_NAME.png
	convert -background none -resize 96x96 $ICON $BASE_DIR/res/drawable-xhdpi/$BASE_NAME.png
#	convert -resize 144x144 $ICON $BASE_DIR/res/drawable-xxdpi/$BASE_NAME.png
#	convert -resize 192x192 $ICON $BASE_DIR/res/drawable-xxxdpi/$BASE_NAME.png
done
